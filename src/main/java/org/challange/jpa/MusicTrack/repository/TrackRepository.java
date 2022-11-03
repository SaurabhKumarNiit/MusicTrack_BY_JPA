package org.challange.jpa.MusicTrack.repository;

import org.challange.jpa.MusicTrack.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track,Integer> {
    public List<Track> findByTrackId(int trackId);

    public List<Track> findByTrackArtist(String trackArtist);
}
