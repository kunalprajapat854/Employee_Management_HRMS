package com.hrms.service;

import java.util.List;

import com.hrms.entities.Position;

public interface PositionService {

	public boolean createPosition(Position position);

	public void updateSalaryRange(Long positionId, Double minSalary, Double maxSalary);

	public Position getPositionId(Long positionId);

	public List<Position> getAllPosition();

}
