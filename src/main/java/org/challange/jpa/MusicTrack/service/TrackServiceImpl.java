package org.challange.jpa.MusicTrack.service;

import org.challange.jpa.MusicTrack.domain.Track;
import org.challange.jpa.MusicTrack.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }
    @Override
    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> gerAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track, int trackId) {

        Optional<Track> optionalUser=trackRepository.findById(trackId);
        if(optionalUser.isEmpty()){
            return null;
        }

       Track existingUser=optionalUser.get();
        if(track.getTrackName()!=null){
            existingUser.setTrackName(track.getTrackName());
        }

        if(track.getTrackArtist()!=null){
            existingUser.setTrackArtist(track.getTrackArtist());
        }
        if(track.getTrackRating()!=null){
            existingUser.setTrackRating(track.getTrackRating());
        }
        if(track.getTrackComments()!=null){
            existingUser.setTrackComments(track.getTrackComments());
        }

        return trackRepository.save(existingUser);
    }

    @Override
    public boolean deleteTrackByTrackId(int trackId) {
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> getTrackByTrackId(int trackId) {
        return trackRepository.findByTrackId(trackId);
    }

    @Override
    public List<Track> getTrackByTrackArtist(String trackArtist) {
        return trackRepository.findByTrackArtist(trackArtist);
    }
}
