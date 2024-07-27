package poly.edu.duantotnghiep.Service.Iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.duantotnghiep.Model.ChatLieu;
import poly.edu.duantotnghiep.Repository.ChatLieuRepository;
import poly.edu.duantotnghiep.Service.ChatLieuService;

import java.util.List;

@Service
public class ChatLieuIml implements ChatLieuService {

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Override
    public List<ChatLieu> getChatLieuALL() {
        return chatLieuRepository.getChatLieuALL();
    }

    @Override
    public void addChatLieuModal(ChatLieu chatLieu) {
        chatLieuRepository.save(chatLieu);
    }
}
