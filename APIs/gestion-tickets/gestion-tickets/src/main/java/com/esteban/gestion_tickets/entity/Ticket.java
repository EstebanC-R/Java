package com.esteban.gestion_tickets.entity;

import com.esteban.gestion_tickets.enums.Priority;
import com.esteban.gestion_tickets.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.time.OffsetDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter

/*
    # Nota sobre constraints:

    $ Las reglas de validación estructural (longitud, valores permitidos, etc.)
    $ están definidas directamente en la base de datos mediante CHECK constraints.
    $
    ! No se utilizan @Check en la entidad para evitar duplicación de reglas
    ! y posibles inconsistencias entre el modelo Java y el esquema SQL.
    $
    $ La base de datos es la fuente de verdad para la integridad estructural.
    $ Las validaciones de entrada se realizan en los DTO mediante Bean Validation.
*/

/*
    @Check(constraints = "char_length(btrim(title)) between 5 and 120")
    @Check(constraints = "char_length(btrim(description)) >= 10")
    @Check(constraints = "status in ('OPEN', 'IN_PROGRESS', 'RESOLVED', 'CLOSED')")
    @Check(constraints = "priority in ('LOW', 'MEDIUM', 'HIGH', URGENT)")
    @Check(constraints = "assignee_email is null or char_length(btrim(assignee_email)) > 0")
*/

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    // ! Por defecto si no se pone el @Enumerated(EnumType.STRING)
    // ! lo va a poner como EnumType.ORDINAL osea como posicion empezando desde cero.

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Priority priority;

    @Column(name = "assignee_email", length = 254, nullable = false)
    private String assigneeEmail;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    /*
        $ Manejo de timestamps:

        # Existen dos formas comunes de gestionar createdAt y updatedAt:

        ? 1) @CreationTimestamp y @UpdateTimestamp (Hibernate):
        ?    - Son más declarativas y reducen código.
        ?    - Funcionan automáticamente en insert y update.
        ?    - Dependen específicamente de Hibernate.
        ?
        ! 2) @PrePersist y @PreUpdate (Lifecycle callbacks JPA):
        !    - Son parte del estándar JPA (más portables).
        !    - Permiten agregar lógica adicional antes de persistir o actualizar
        !      (por ejemplo, establecer el status por defecto).
        !
         * En este caso se utilizan lifecycle callbacks porque, además de manejar
         * los timestamps, se requiere lógica adicional y se busca evitar depender
         * exclusivamente de extensiones específicas del proveedor ORM.
         *
        % ORM: La herramienta concreta que implementa la especificación JPA y se
        % encarga de convertir tus entidades en SQL real.
    */

    @PrePersist
    public void prePersist() {
        OffsetDateTime now = OffsetDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        if(this.status == null){
            this.status = Status.OPEN;
        }
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = OffsetDateTime.now();
    }
}
