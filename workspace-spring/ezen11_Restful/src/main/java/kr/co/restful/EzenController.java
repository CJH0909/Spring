package kr.co.restful;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/*")
public class EzenController {

		static Logger logger = LoggerFactory.getLogger(EzenController.class);
		
		// /rest/hello 요청 시 브라우저로 문자열 전송함
		@RequestMapping("/hello")
		public String hello() {
			return "Hello Rainy Season";
		}
		//MemberDTO 객체의 속성 값을 저장하고 JSON으로 전송함
		@RequestMapping("/member")
		public MemberDTO member() {
			MemberDTO dto = new MemberDTO();
			dto.setId("ezen");
			dto.setPwd("0824");
			dto.setName("ezen");
			dto.setEmail("ezen0713@gmail.com");
			return dto;
		}
		
		@RequestMapping("/memberList")
		public List<MemberDTO> listMembers(){
			//dto 객체를 저장할 컬렉션 객체 생성
			List<MemberDTO> list = new ArrayList<>();
			//객체 10개 생성해 컬렉션에 저장	
			for(int i=0;i<10;i++) {
				MemberDTO dto = new MemberDTO();
				dto.setId("ezen"+ i);
				dto.setPwd("0824"+ i);
				dto.setName("이젠IT"+ i);
				dto.setEmail("ezen"+ i+"@gmail.com");
				list.add(dto);
			}
			
			return list;	//arrayList를 JSON으로 브라우저에 전송함
		}
		@RequestMapping("/membersMap")
		public Map<Integer, MemberDTO> membersMap(){
			//MemberDTO를 저장할 HashMap 객체 생성
			Map<Integer, MemberDTO> map = new HashMap<>();
			
			for(int i=0;i<10;i++) {
				MemberDTO dto = new MemberDTO();
				dto.setId("ezen"+ i);
				dto.setPwd("0824"+ i);
				dto.setName("이젠IT"+ i);
				dto.setEmail("ezen"+ i+"@gmail.com");
				map.put(i, dto); //dto 객체 10개 생성해 HashMap에 저장함
			}
			return map;
		}
		@RequestMapping(value="/notice/{num}")
		public int notice(@PathVariable("num") int num) throws Exception {
					//요청 URL에서 지정된 값이 num에 자동으로 할당됨
			return num;
		}
		
		@RequestMapping(value="/info", method=RequestMethod.POST)
		//JSON 전송된 데이터를 MemberDTO 객체의 속성에 자동으로 설정해 줌
		public void modify(@RequestBody MemberDTO dto) {
			logger.info(dto.toString());
		}
}