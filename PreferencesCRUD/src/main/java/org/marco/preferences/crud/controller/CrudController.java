package org.marco.preferences.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/crud")
public class CrudController {

	@GetMapping()
	public Mono<Result> getResult() {
		return Mono.just(new Result(0, "4545"));
	}
}

@Getter
@Setter
@AllArgsConstructor
class Result {
	int a;
	String b;
}
