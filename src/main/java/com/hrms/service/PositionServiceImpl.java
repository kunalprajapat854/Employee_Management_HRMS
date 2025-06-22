package com.hrms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.hrms.entities.Position;
import com.hrms.repository.core.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {

	private PositionRepository positionRepository;

	public PositionServiceImpl(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}

	public boolean createPosition(Position position) {
		Position save = positionRepository.save(position);
		return save != null;
	}

	public void updateSalaryRange(Long positionId, Double minSalary, Double maxSalary) {
		Optional<Position> positionIdd = positionRepository.findById(positionId);
		if (positionIdd.isPresent()) {
			Position position = positionIdd.get();
			position.setMinSalary(minSalary);
			position.setMaxSalary(maxSalary);

			positionRepository.save(position);

		} else {
			throw new RuntimeException("Position is not found with :" + positionId);
		}

	}

	public Position getPositionId(Long positionId) {
		Optional<Position> byId = positionRepository.findById(positionId);
		if (byId.isPresent()) {
			byId.get();
		}
		return null;
	}

	public List<Position> getAllPosition() {
		return positionRepository.findAll();

	}

}
