package com.hrms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "notifications")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Title is required")
	@Size(max = 200, message = "Title must not exceed 200 characters")
	@Column(name = "title", nullable = false, length = 200)
	private String title;

	@NotBlank(message = "Message is required")
	@Size(max = 1000, message = "Message must not exceed 1000 characters")
	@Column(name = "message", nullable = false, length = 1000)
	private String message;

	@NotNull(message = "Notification type is required")
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false, length = 30)
	private NotificationType type;

	@NotNull(message = "Priority is required")
	@Enumerated(EnumType.STRING)
	@Column(name = "priority", nullable = false, length = 10)
	private Priority priority;

	@NotNull(message = "Status is required")
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 15)
	private Status status = Status.UNREAD;

	@Column(name = "is_read", nullable = false)
	private Boolean isRead = false;

	@Column(name = "read_at")
	private LocalDateTime readAt;

	@Column(name = "scheduled_at")
	private LocalDateTime scheduledAt;

	@Column(name = "sent_at")
	private LocalDateTime sentAt;

	@Column(name = "expires_at")
	private LocalDateTime expiresAt;

	@Size(max = 500, message = "Action URL must not exceed 500 characters")
	@Column(name = "action_url", length = 500)
	private String actionUrl;

	@Size(max = 100, message = "Action text must not exceed 100 characters")
	@Column(name = "action_text", length = 100)
	private String actionText;

	@Column(name = "is_system_generated", nullable = false)
	private Boolean isSystemGenerated = true;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	// Foreign Key Relationships
	@NotNull(message = "Recipient is required")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipient_id", nullable = false)
	private Employee recipient;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_id")
	private Employee sender;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "related_employee_id")
	
	private Employee relatedEmployee;

	// Enums
	public enum NotificationType {
		LEAVE_REQUEST("Leave Request"), LEAVE_APPROVAL("Leave Approval"), LEAVE_REJECTION("Leave Rejection"),
		ATTENDANCE_ALERT("Attendance Alert"), PAYROLL_GENERATED("Payroll Generated"),
		PERFORMANCE_REVIEW("Performance Review"), TRAINING_ASSIGNMENT("Training Assignment"),
		TRAINING_REMINDER("Training Reminder"), BIRTHDAY_REMINDER("Birthday Reminder"),
		WORK_ANNIVERSARY("Work Anniversary"), DOCUMENT_EXPIRY("Document Expiry"), POLICY_UPDATE("Policy Update"),
		SYSTEM_MAINTENANCE("System Maintenance"), GENERAL_ANNOUNCEMENT("General Announcement"),
		TASK_ASSIGNMENT("Task Assignment"), MEETING_REMINDER("Meeting Reminder"),
		SALARY_SLIP_READY("Salary Slip Ready"), ONBOARDING("Onboarding"), EXIT_PROCESS("Exit Process");

		private final String displayName;

		NotificationType(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
	}

	public enum Priority {
		LOW("Low"), MEDIUM("Medium"), HIGH("High"), URGENT("Urgent");

		private final String displayName;

		Priority(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
	}

	public enum Status {
		UNREAD("Unread"), READ("Read"), ARCHIVED("Archived"), DELETED("Deleted");

		private final String displayName;

		Status(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
	}

}