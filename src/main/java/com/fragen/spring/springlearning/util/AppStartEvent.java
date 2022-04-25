package com.fragen.spring.springlearning.util;

import com.fragen.spring.springlearning.data.Room;
import com.fragen.spring.springlearning.data.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class AppStartEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;

    public AppStartEvent( RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);
    }
}
