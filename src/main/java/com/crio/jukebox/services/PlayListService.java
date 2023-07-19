package com.crio.jukebox.services;

import java.util.ArrayList;
import java.util.List;
import javax.print.event.PrintJobListener;
import com.crio.jukebox.repositories.UserRepository;
import com.crio.jukebox.exceptions.UserNotFoundException;
import com.crio.jukebox.entities.PlayList;
import com.crio.jukebox.entities.Songs;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.PlayListNotFoundException;
import com.crio.jukebox.exceptions.SongNotFoundException;
import com.crio.jukebox.repositories.PlayListRepository;
import com.crio.jukebox.repositories.SongsRepository;

public class PlayListService implements IPlayListService {

    private final PlayListRepository playListRepository;
    private final SongsRepository songsRepository;
    private final UserRepository userRepository;

 

    public PlayListService(PlayListRepository playListRepository,SongsRepository songsRepository, UserRepository userRepository) {
        this.playListRepository = playListRepository;
        this.songsRepository = songsRepository;
        this.userRepository = userRepository;
    }

    public List<Songs> returnSongsList(List<String> sIds)
    {
        List<Songs> s_obj = new ArrayList<>();
        for(String p : sIds)
        {
            Songs t = songsRepository.findSongById(p);
            s_obj.add(t);
        }
        return s_obj;
    }

    // .orElseThrow(() -> new SongNotFoundException("Cannot create playlist. Some songs are not available in Song repository!"))
    // public List<PlayList> returnPlayList(User user,List<String> pIds)
    // {
    //     List<PlayList> p_obj = new ArrayList<>();
    //     for(String p : pIds)
    //     {
    //         p_obj.add(user.getPlayListById1(p).orElseThrow(() -> new PlayListNotFoundException("Cannot delete playlist. Playlist for given id:"+p+" not found in user list of playlist!")));
    //     }
    //     return p_obj;
    // }


    @Override
    public PlayList createPlayList(String userId, String PlayListName, List<String> LsongIds) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot create playlist. User for given id:"+userId+" not found!"));
        Integer t_id = playListRepository.count() + 1;
        PlayList t_obj = new PlayList(t_id.toString(),userId ,PlayListName ,returnSongsList(LsongIds));
        user.addPlayList(t_obj);
        userRepository.save(user);
        playListRepository.save(t_obj);
        return t_obj;
    }

    @Override
    public PlayList deletePlayList(String userId, String playListId) {
        final User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot delete playlist. User for given id:"+userId+" not found!"));
        
        if(user.getPlayListById(playListId).orElseThrow(() -> new PlayListNotFoundException("Cannot delete playlist. Playlist for given id:"+playListId+" not found in user list user playlist!"))!=null)
        {
            PlayList p_obj1 = playListRepository.deletePlayList(playListId);
            user.removePlayList(p_obj1);
            userRepository.save(user);
            return p_obj1;
        }  
        return null;
    }

    public PlayList play(String userId,String playListId)
    {
        final User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot play playlist. User for given id:"+userId+" not found!"));
        final PlayList playList = playListRepository.getPlayList(playListId);
        if(user != null && playList.equals(user.getPlayListByPlayList(playList).orElseThrow(() -> new PlayListNotFoundException("Cannot play the playlist. Playlist for given id:"+playListId+" not found in user list of user playlist!"))))
        { 
            return playList;
        }         
        return null;
    }
    
    @Override
    public Songs playSong(String userId, String arg, PlayList cpList,Songs cSong)
    {
        Integer c_Sid = cpList.getIndexOfSong(cSong);
        if(arg.equals("BACK"))
        {
            if(c_Sid!=0)
            {
                return cpList.getSongsById(c_Sid-1);
            }
            else{
                return cpList.getSongsById(cpList.getSongsListSize()-1);
            }
        }else if(arg.equals("NEXT"))
        {
            if(c_Sid!=cpList.getSongsListSize()-1)
            {
                return cpList.getSongsById(c_Sid + 1);
            }
            else{
                return cpList.getSongsById(0);
            }
        }else{
            if(cpList.getSongsById1(Integer.parseInt(arg)) != null)
            {
                return cpList.getSongsById1(Integer.parseInt(arg));
            }
            else{
                return null;
            }
        }
    }
    
    @Override
    public PlayList addSongs(String userId,String playListId,List<String> songsIds)
    {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot add songs to playlist. User for given id:"+userId+" not found!"));
        PlayList pl = user.getPlayListById(playListId).orElseThrow(() -> new PlayListNotFoundException("Cannot add songs to the playlist. Playlist for given id:"+playListId+" not found in user list of user playlist!"));
        user.removePlayList(pl);
        pl.addSongsToList(returnSongsList(songsIds));
        playListRepository.save(pl);
        user.addPlayList(pl);
        return pl;
    }

    @Override
    public PlayList deleteSongs(String userId,String playListId,List<String> songsIds)
    {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot delete songs from playlist. User for given id:"+userId+" not found!"));
        PlayList pl = user.getPlayListById(playListId).orElseThrow(() -> new PlayListNotFoundException("Cannot add songs to the playlist. Playlist for given id:"+playListId+" not found in user list of user playlist!"));
        user.removePlayList(pl);
        pl.deleteSongsFromList(returnSongsList(songsIds));
        playListRepository.save(pl);
        user.addPlayList(pl);
        return pl;
    }

    

}
