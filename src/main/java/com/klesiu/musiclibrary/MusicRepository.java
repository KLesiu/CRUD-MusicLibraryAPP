package com.klesiu.musiclibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Music> getAll(){
        return jdbcTemplate.query("SELECT id,title,artist FROM song",
                BeanPropertyRowMapper.newInstance(Music.class));

    };
    public Music getById(int id){
       return jdbcTemplate.queryForObject("SELECT id,title,artist FROM song WHERE id=?",
               BeanPropertyRowMapper.newInstance(Music.class)
               ,id);
    };
    public int save(List<Music> songs){
        songs.forEach(song->jdbcTemplate.
                update("INSERT INTO song(title,artist) VALUES(?,?)",
                        song.getTitle(),song.getArtist()
                ));
        return 1;

    }
    public int update(Music song){
        return jdbcTemplate.update("UPDATE song SET title=?,artist=? WHERE id=?",song.getTitle(),song.getArtist(),song.getId());
    }
    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM song WHERE id=?",id);
    }

}
