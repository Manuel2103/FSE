package dataaccess;

import domain.Course;
import domain.CourseType;

import java.util.Date;
import java.util.List;

/**
 * Das Interface MyCourseRepository ist das DAO Interface und erbt von dem BaseRepository. Bei der Vererbung ist zu beachten, dass die Typen deklariert werden.
 * In diesem Interface werden weitere spezifischere Methodenköpfe hinzugefügt.
 */
public interface MyCourseRepository extends BaseRepository<Course, Long>{
 
    List<Course> findAllCoursesByName(String name);
    List<Course> findAllCoursesByDescription(String description);
    List<Course> findAllCoursesByDescriptionOrName(String searchText);
    List<Course> findAllCoursesByCourseType(CourseType courseType);
    List<Course> findAllCoursesByStartDate(Date startDate);
    List<Course> findAllRunningCourses();
}
