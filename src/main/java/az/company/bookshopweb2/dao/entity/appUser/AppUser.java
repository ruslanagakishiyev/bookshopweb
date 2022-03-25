package az.company.bookshopweb2.dao.entity.appUser;

import az.company.bookshopweb2.enums.AppUserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "appUser")
public class AppUser  {

   @Id
   @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer bornTime;
    private Integer phoneNumber;
    private String address;

    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked = false;
    private Boolean enabled = false;


    public AppUser(String firstName, String lastName, String email, String password, int bornTime, int phoneNumber, String adress, AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bornTime = bornTime;
        this.phoneNumber = phoneNumber;
        this.address = adress;
        this.appUserRole = appUserRole;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
//        return Collections.singletonList(authority);
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public int getBornTime() {
//        return bornTime;
//    }
//
//    public int getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return !locked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
}
