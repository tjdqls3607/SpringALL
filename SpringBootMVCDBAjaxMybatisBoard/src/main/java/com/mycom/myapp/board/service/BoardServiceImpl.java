
package com.mycom.myapp.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.mycom.myapp.board.dao.BoardDao;
import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;

@Service
public class BoardServiceImpl implements BoardService{
	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public BoardResultDto listBoard(BoardParamDto boardParamDto) { // limit, offset 넘어옴
		BoardResultDto boardResultDto = new BoardResultDto();
		
		// 예외 처리
		// 처리과정 중 오류 발생
		//	1. 직접 제어 (사용)
		// 	2. Spring FrameWork 처리 의뢰 /error mapping
		try {
			// BoardController는 BoardService의 listBoard() 1회 호출
			// BoardService 는 BoardDao의 listBoard()와 listBoardTotalCOunt() 2개 호출
			List<BoardDto> list = boardDao.listBoard(boardParamDto);
			int count = boardDao.listBoardTotalCount();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult("success");
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		return boardResultDto;
	}
	
	@Override
	public BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto) { // limit, offset 넘어옴
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			// BoardController는 BoardService의 listBoard() 1회 호출
			// BoardService 는 BoardDao의 listBoard()와 listBoardTotalCOunt() 2개 호출
			List<BoardDto> list = boardDao.listBoardSearchWord(boardParamDto);
			int count = boardDao.listBoardTotalCountSearchWord(boardParamDto);
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult("success");
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		return boardResultDto;
	}
	
	// 게시글 상세 정보 + 조회수 처리
	//transaction test
	//	1. @Transactional X (Spring Transaction 관리 AOP 관여 X)
	//		insert O, update X
	//	2. @Transactional O (Spring Transaction 관리 AOP 관여 O, PointCut에 추가)
	//		1. RuntimeException 계열 객체 throw 되어서 Transaction 관련 AOP에 전달되면 => rollback
	//		2. 예외 발생 X => Transaction 관리 AOP 가 Commit
	//		3. runtimeexception 계열 객체 throw가 되어소 try-catch로 묶어버리면 상위로 전달X
	//			catch block에서 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();을 통해 rollback 처리
	@Override
	@Transactional
	public BoardResultDto detailBoard(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			// 조회수 처리
			// 게시글 상세 정보
			int userReadCnt = boardDao.countBoardUserRead(boardParamDto);
			
			System.out.println("boardId : " + boardParamDto.getBoardId());
			System.out.println("userSeq : " + boardParamDto.getUserSeq());
			System.out.println("userReadCnt : " + userReadCnt);
			
			if(userReadCnt == 0) { // 현재 게시글을 처음 읽는 상황
				boardDao.insertBoardUserRead(boardParamDto); // 현재 게시글을 현재 사용자가 읽었다. 표시 증록
				
				//transaction test
//				String s = null;
//				s.length();
				boardDao.updateBoardReadCount(boardParamDto.getBoardId()); // 현재 게시글 조회수 증가 처리
			}
			// 게시글 상세 정보
			BoardDto boardDto = boardDao.detailBoard(boardParamDto);
			// same User
			if(boardDto.getUserSeq() == boardParamDto.getUserSeq()) {
				boardDto.setSameUser(true);
			}else {
				boardDto.setSameUser(false);				
			}
			
			boardResultDto.setDto(boardDto);
			boardResultDto.setResult("success");
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
			
			//spring 제안 방법
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			//RuntimeException 객체 생성 & throw
//			throw new RuntimeException("");
//			throw new IllegalStateException("");
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto insertBoard(BoardDto boardDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			int ret = boardDao.insertBoard(boardDto);
			
			if(ret == 1) boardResultDto.setResult("success");
			else boardResultDto.setResult("fail");
			
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		return boardResultDto;
	}
	
	@Override
	public BoardResultDto updateBoard(BoardDto boardDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			int ret = boardDao.updateBoard(boardDto);
			
			if(ret == 1) boardResultDto.setResult("success");
			else boardResultDto.setResult("fail");
			
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		return boardResultDto;
	}

	@Override
	@Transactional
	public BoardResultDto deleteBoard(int boardId) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			int ret1 = boardDao.deleteBoardUserRead(boardId);
			int ret2 = boardDao.deleteBoard(boardId);
			
			// 오류 테스트
//			String s = null;
//			s.length();
			
			if(ret1 == 1 && ret2 == 1) boardResultDto.setResult("success");
			else boardResultDto.setResult("fail");
			
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return boardResultDto;
	}
}
