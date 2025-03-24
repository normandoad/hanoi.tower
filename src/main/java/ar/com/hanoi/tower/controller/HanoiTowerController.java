package ar.com.hanoi.tower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.hanoi.tower.impl.HanoiTowerService;

@RestController
public class HanoiTowerController {


	@Autowired
	private HanoiTowerService hanoiTowerService;

	@GetMapping("/")
	public String hanoiGameInit(final @RequestParam(defaultValue = "50") String numDiscos) {

		hanoiTowerService.hanoiGameInit(Integer.valueOf(numDiscos));

		return numDiscos;
	}

}
