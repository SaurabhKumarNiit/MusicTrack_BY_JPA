package org.challange.jpa.MusicTrack.controller;

import org.challange.jpa.MusicTrack.domain.Track;
import org.challange.jpa.MusicTrack.service.TrackService;
import org.challange.jpa.MusicTrack.service.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musictrack/app/")
public class TrackController {
    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService){

        this.trackService=trackService;
    }

    @PostMapping("/track")
    public ResponseEntity<?> insertUser(@RequestBody Track track){

        return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.CREATED);
    }

    @GetMapping("/tracks")
    public ResponseEntity<?> getUserDetails(){
        return new ResponseEntity<>(trackService.gerAllTrack(),HttpStatus.FOUND);
    }

    @DeleteMapping("/track/{trackId}")
    public ResponseEntity<?> deleteUser(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.deleteTrackByTrackId(trackId),HttpStatus.OK);
    }

    @GetMapping("/track/{trackId}")
    public ResponseEntity<?> fetchByTrackId(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.getTrackByTrackId(trackId),HttpStatus.FOUND);
    }

    @GetMapping("/tracks/{trackArtist}")
    public ResponseEntity<?> fetchByTrackArtist(@PathVariable String trackArtist){
        return new ResponseEntity<>(trackService.getTrackByTrackArtist(trackArtist),HttpStatus.FOUND);
    }


    @PutMapping("/track/{trackId}")
    public ResponseEntity<?> updateUser(@RequestBody Track track,@PathVariable int trackId){
        return new ResponseEntity<>(trackService.updateTrack(track,trackId),HttpStatus.OK);
    }

}
