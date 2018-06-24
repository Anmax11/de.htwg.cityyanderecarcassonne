package de.htwg.cityyanderecarcassonne.persistence.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player")
public class PersistentPlayer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name")
    private String name;

    @Column(name = "sum_meeples")
    private int sumMeeples;

    @Column(name = "score")
    private int score;

    @ManyToOne
    @JoinColumn(name = "save_game_id", nullable = false)
    private PersistentSaveGame savegame;

    public PersistentPlayer() {}
    public PersistentPlayer(String name, int sumMeeples, int score) {
        this.name = name;
        this.sumMeeples = sumMeeples;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumMeeples() {
        return sumMeeples;
    }

    public void setSumMeeples(int sumMeeples) {
        this.sumMeeples = sumMeeples;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public PersistentSaveGame getSavegame() {
        return savegame;
    }

    public void setSavegame(PersistentSaveGame savegame) {
        this.savegame = savegame;
    }
}
