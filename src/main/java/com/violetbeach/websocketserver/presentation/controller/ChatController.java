package com.violetbeach.websocketserver.presentation.controller;

import com.violetbeach.websocketserver.application.ChatRoom;
import com.violetbeach.websocketserver.application.ChatService;
import com.violetbeach.websocketserver.application.request.CreateRoomRequest;
import com.violetbeach.websocketserver.presentation.controller.request.CreateRoomCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chats")
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ChatRoom createRoom(@RequestBody CreateRoomCommand command) {
        CreateRoomRequest request = toRequest(command);
        return chatService.createRoom(request);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }

    private CreateRoomRequest toRequest(CreateRoomCommand createRoomCommand) {
        return new CreateRoomRequest(
                createRoomCommand.getName()
        );
    }
}