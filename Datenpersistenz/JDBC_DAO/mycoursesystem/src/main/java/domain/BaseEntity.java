package domain;

/**
 * Die Klasse BaseEntity dient als Mutterklasse konkreter Entitäten wie zum Beispiel Course
 * Alle weiteren Entitäten besitzen eine ID.
 */
public abstract class BaseEntity  {
     private Long id;

     public BaseEntity(Long id){
         setId(id);
     }
     public Long getId(){
         return this.id;
     }

     public void setId(Long id){
         //ID muss null oder größer gleich 0 Sein
         if(id==null|| id >=0){
             this.id = id;
         }else {
             throw new InvalidValueException("Kurs-ID muss größer gleich 0 sein");
         }
     }
}
