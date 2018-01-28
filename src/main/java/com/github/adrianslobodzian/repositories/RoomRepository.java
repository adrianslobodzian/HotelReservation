package com.github.adrianslobodzian.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.adrianslobodzian.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

//	@Query(value = "SELECT room_size FROM Hotel.room GROUP BY room_size", nativeQuery	=	true)
//	List<Integer> customFindRoomSize();
	
	
//	@Query("select room from Reservation reservation LEFT JOIN reservation.room room where (reservation.starts > ?1) or (reservation.ends <= ?2) or (reservation is null)")
//	List<Room> customFindByRoomSize(LocalDate ends, LocalDate starts);
	
//	@Query(value = "SELECT * FROM room LEFT JOIN reservation on reservation.room_id=room.id WHERE reservation.starts> ?1 OR reservation.ends<= ?2 OR reservation.created is NULL", nativeQuery	=	true)   
//	List<Room> customFindByDateStartsEnds(LocalDate ends, LocalDate starts);
	
//	@Query(value = "SELECT room_size FROM room LEFT JOIN reservation on reservation.room_id=room.id WHERE reservation.starts> ?1 OR reservation.ends<= ?2 OR reservation.created is NULL GROUP BY room_size", nativeQuery	=	true)   
//	List<Integer> customFindByRoomSizeBy(LocalDate ends, LocalDate starts);
	
	@Query(value = "SELECT * FROM room LEFT JOIN reservation on reservation.room_id=room.id WHERE (reservation.starts<= ?1 AND reservation.ends>= ?1 AND reservation.ends<=?2 AND reservation.starts<= ?2) OR (reservation.starts<=?2 AND reservation.ends>=?2 AND reservation.ends>=?1 AND reservation.starts>= ?1 )OR (reservation.starts>= ?1 AND reservation.starts<= ?2 AND reservation.ends>=?1 AND reservation.ends<=?2);", nativeQuery	=	true)   
	List<Room> customFindByDateStartsEnds2(LocalDate starts, LocalDate ends);
	
	@Query ("SELECT DISTINCT(room.roomSize) FROM Room room ")
	List<Integer> customFindByRoomSizeGroupByRoomSize();
}
