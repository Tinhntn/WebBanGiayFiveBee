package poly.edu.duantotnghiep.Service;

import poly.edu.duantotnghiep.Model.ChatLieu;

import java.util.List;

public interface ChatLieuService {

    List<ChatLieu> getChatLieuALL();

    void addChatLieuModal(ChatLieu chatLieu);
}
