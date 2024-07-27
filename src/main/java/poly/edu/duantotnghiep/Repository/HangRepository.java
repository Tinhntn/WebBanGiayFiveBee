package poly.edu.duantotnghiep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.edu.duantotnghiep.Model.Hang;

import java.util.List;
import java.util.UUID;

@Repository

public interface HangRepository extends JpaRepository<Hang, UUID> {

    @Query(value = "select * from Hang", nativeQuery = true)
    List<Hang> getHangALL();

}
