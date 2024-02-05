package equoterapia.equo.entidades;

import jakarta.persistence.Table;

@Table(name = "tb_role")
public enum Role {
    ADMIN("ADMIN", 0),
    USER("USER", 1);

    private String role;

    Role(String role, int i) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}