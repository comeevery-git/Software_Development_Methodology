package app.domain.model.entity;

import app.domain.model.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Schema(description = "회원 정보 Entity")
@Entity
@Table(name="member", uniqueConstraints = {
        @UniqueConstraint(name = "NAME_EMAIL_UNIQUE", columnNames = {"name", "email"})
    }
)
public class Member {
    @Id
    @Column(name = "member_id", nullable = false)
    @Schema(description = "회원 고유 아이디", example = "M2312310001")
    private String memberId;

    @Column(name = "name", nullable = false, length = 10)
    @Schema(description = "회원 이름", example = "김동동")
    private String name;

    @Column(name = "email", nullable = false)
    @Schema(description = "회원 이메일", example = "example@gmail.com")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @Schema(description = "회원 권한", example = "MEMBER")
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    @Schema(description = "최초 생성일", example = "2021-07-01T00:00:00")
    private LocalDateTime createdDate;

    @Column(name = "created_member_id", nullable = false)
    @Schema(description = "최초 생성 회원 아이디", example = "2021-07-01T00:00:00")
    private String createdMemberId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    @Schema(description = "최종 수정일", example = "2021-07-01T00:00:00")
    private LocalDateTime updatedDate;

    @Column(name = "updated_member_id")
    @Schema(description = "최종 수정 회원 아이디", example = "M2312310001")
    private String updatedMemberId;
}