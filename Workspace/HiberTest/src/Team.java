import java.util.Set;  
  
import javax.persistence.*;  
  
@Entity  
@Table(name = "teams")  
public class Team {  
  
    @Id  
    @GeneratedValue  
    private Integer id;  
      
    private String name;  
      
    @OneToMany(mappedBy="team", cascade=CascadeType.ALL)  
    private Set<Player> players;  
      
    public Team(String name) {  
        this.name = name;  
    }  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public Set<Player> getPlayers() {  
        return players;  
    }  
  
    public void setPlayers(Set<Player> players) {  
        this.players = players;  
    }  
}  