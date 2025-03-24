package ar.com.hanoi.tower.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HanoiTowerService {

	public void hanoiGameInit(final Integer numDiscos) {
		log.info("init hanoiGameInit");
		try {
			ArrayList<Integer> torre1 = new ArrayList<Integer>();
			ArrayList<Integer> torre2 = new ArrayList<Integer>();
			ArrayList<Integer> torre3 = new ArrayList<Integer>();

			// Inicializar la torre1 con los discos
			for (int i = numDiscos; i > 0; i--) {
				torre1.add(i);
			}
			
			log.info("Inicio Torre 1: " + torre1);
			log.info("Inicio Torre 2: " + torre2);
			log.info("Inicio Torre 3: " + torre3);

			// Resolver el problema
			moverDiscos(numDiscos, torre1, torre3, torre2);

			// Mostrar el estado final de las torres
			log.info("Fin Torre 1: " + torre1);
			log.info("Fin Torre 2: " + torre2);
			log.info("Fin Torre 3: " + torre3);

		} finally {
			log.info("end hanoiGameInit");
		}
	}

	private static void moverDiscos(Integer numDiscos, ArrayList<Integer> origen, ArrayList<Integer> destino,
			ArrayList<Integer> auxiliar) {
		if (numDiscos == 1) {
			// Mover disco de la torre origen a la torre destino
			destino.add(origen.remove(origen.size() - 1));
		} else {
			// Mover n-1 discos al auxiliar
			moverDiscos(numDiscos - 1, origen, auxiliar, destino);
			// Mover el disco restante al destino
			destino.add(origen.remove(origen.size() - 1));
			// Mover los n-1 discos del auxiliar al destino
			moverDiscos(numDiscos - 1, auxiliar, destino, origen);
		}
	}
}
