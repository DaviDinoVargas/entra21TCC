package equoterapia.equo.dtos;

import equoterapia.equo.entidades.Usuario;

public class UsuarioDTO {
    private Long id;  
    private String email;

    public UsuarioDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}