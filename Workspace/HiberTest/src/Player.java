import javax.persistence.*;  
  
@Entity  
@Table(name = "players")  
public class Player {  
  
    @Id  
    @GeneratedValue  
    private Integer id;  
  
    private String lastname;  
  
    @ManyToOne  
    @JoinColumn(name = "team_id")  
    private Team team;  
  
    public Player(String lastname) {  
        this.lastname = lastname;  
    }  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getLastname() {  
        return lastname;  
    }  
  
    public void setLastname(String lastname) {  
        this.lastname = lastname;  
    }  
  
    public Team getTeam() {  
        return team;  
    }  
  
    public void setTeam(Team team) {  
        this.team = team;  
    }  
}  