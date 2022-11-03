package org.challange.jpa.MusicTrack.service;

import org.challange.jpa.MusicTrack.domain.Track;

import java.util.List;

public interface TrackService {

    public Track addTrack(Track track);
    public List<Track> gerAllTrack();
    public Track updateTrack(Track track,int trackId);
    public boolean deleteTrackByTrackId(int trackId);

    public List<Track> getTrackByTrackId(int trackId);
    public List<Track> getTrackByTrackArtist(String trackArtist);
}
