package com.fuji.inventory.fujiInv.models;
import jakarta.persistence.*;
import lombok.*;

import java.security.Principal;
import java.util.List;

@Entity
@Table(name = "inventory_of_assets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "plant")
    private String plant;
    @Column(name = "fae_number")
    private String fae_number;
    @Column(name = "sis_number")
    private String sis_number;
    @Column(name = "item_name")
    private String itemname;
    @Column(name = "item_brand")
    private String item_brand;
    @Column(name = "item_model")
    private String item_model;
    @Column(name = "serial_number")
    private String serial_number;
    @Column(name = "location")
    private String location;
    @Column(name = "hostname")
    private String hostname;
    @Column(name = "ip_address")
    private String ip_address;
    @Column(name = "isDamaged")
    private boolean isDamaged;
    @Column(name = "user_name")
    private String user_name;
    @Column(name="departmetn")
    private String department;
    @Column(name = "operator_namber")
    private String operator_number;

    @Column(name = "user_added")
    private String user_added_item;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private ItemName itemName;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<Image> image;

    @JoinTable(
            name = "items_movements_logs",
            joinColumns = @JoinColumn(
                    name = "item_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "log_id",
                    referencedColumnName = "log_id"
            )
    )
    @OneToMany
    private List<Logs> logs;

    @PrePersist
    public void init(){
        if (ip_address==null){
            ip_address = "No IP Address";
        }
        if (hostname == null){
            hostname = "No HostNAme";
        }
    }

}
