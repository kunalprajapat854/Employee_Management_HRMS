package com.hrms.repository.core.supportDocs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.Notification;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
