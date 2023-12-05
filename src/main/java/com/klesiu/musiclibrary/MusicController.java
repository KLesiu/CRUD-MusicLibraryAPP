package com.klesiu.musiclibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/songs")
public class MusicController {

    @Autowired
    MusicRepository musicRepository;
    @GetMapping("")
    public List<Music> getAll(){
        return musicRepository.getAll();

    }
    @GetMapping("/{id}")
    public Music getById(@PathVariable("id") int id){
        return musicRepository.getById(id);
    }
    @PostMapping("")
    public String add(@RequestBody List<Music> songs){
        musicRepository.save(songs);
        return "Created";
    }
    @PutMapping("/{id}")
    public String update(@PathVariable("id") int id,@RequestBody Music updatedSong){
        Music song = musicRepository.getById(id);
        if(song != null){
            song.setTitle(updatedSong.getTitle());
            song.setArtist(updatedSong.getArtist());
            musicRepository.update(song);
            return "Updated";
        }
        else{
            return "Error";
        }
    }
    @PatchMapping("/{id}")
    public String patchUpdate(@PathVariable("id") int id,@RequestBody Music updateSong){
        Music song = musicRepository.getById(id);
        if(song != null){
            if(updateSong.getTitle() != null){
                song.setTitle(updateSong.getTitle());
            }
            if(updateSong.getArtist() != null){
                song.setArtist(updateSong.getArtist());
            }
            musicRepository.update(song);
            return "Updated";
        }else{
            return "Error";
        }

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        musicRepository.delete(id);
        return "Deleted";
    }
}
