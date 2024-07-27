package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.Model.ChatLieu;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, UUID> {

    @Query(value = "select * from ChatLieu", nativeQuery = true)
    List<ChatLieu> getChatLieuALL();

}
