package org.example.pfeamal.Repositories;


import org.example.pfeamal.Entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Long> {

//   // long countByEtat_CompleteAndmatiereNameAndDatedebut_Year(String Name, Long Year);
//
//
    //long count();
    //Long countBymatiere
//
//    @Override
//    <S extends Formation, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
    //Long countByEtatAnd
        //Long countByTypeAndEtat()
   // @Query(value = "")
   //int countByType_INTERNE();
   // long countByType_Externe();

    //Long countByEtat_COMPLETE()
    @Query("select count(f) from Cours f")
    Long nbrformation();

//    @Query("select count(f) from Formation f where f.type =?1")
//    Long nbrformationbytype(TypeFormation type);



//    @Query("select f from Formation f where f.type =?1")
//    List<Formation> listformationbytype(TypeFormation type);
//    @Query("select count (f) from Formation f , matiereFormation c where f.matiere.name =?2 and year(f.datedebut)=?3 and f.etat=?1 ")
//    int countByEtatCompleteAndmatiereNameAndDatedebutYear(EtatFormation etat, String Name, int Year);
//
//    @Query("select f from Formation f , matiereFormation c where f.matiere.name =?2 and year(f.datedebut)=?3 and f.etat=?1 ")
//    List<Formation> findByEtatCompleteAndmatiereNameAndDatedebutYear(EtatFormation etat, String Name, int Year);
//
//    @Query(value = "select f from Formation f where f.etat=?1")
//    List<Formation> listFormationEtat(EtatFormation etat );


    @Query(value = "select f from  Cours f where  year(f.datedebut)=?2 and f.matiere.name=?1")
    List<Cours> selectByCategoruandyear(String category, int year);



//    @Query(value = "")
//    List<Formation> listFbyDep(Long idd);

//    @Query(value = "select e from Employe e ,Inscription i,Formation f, MembreInscription m where m.inscrit.Formationins=?1")
//    List<Employe> selectEssubinF(Long idf);

//    @Query(value = "select e from Employe e,MembreInscription m ,Inscription i,Formation f where m.inscrit.Formationins.id=?1 and m.membre.id=e.id")
//    List<Employe> selectEsubinF(Long idf);

//    @Query("SELECT f FROM Formation f WHERE f.datefin = :yesterday  AND f.etat = 'COMPLETE'")
//    List<Formation> findByDateFin(@Param("yesterday") Date yesterday);


    @Query("SELECT f FROM Cours f WHERE f.etat = 'COMPLETE'")
    List<Cours> findByDateFin();


@Query("select f from Cours f where f.datefin=?1")
    List<Cours> formation_termine_hier(Date d);
}
