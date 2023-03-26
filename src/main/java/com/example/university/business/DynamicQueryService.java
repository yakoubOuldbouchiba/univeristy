package com.example.university.business;

import com.example.university.domain.Course;
import com.example.university.repo.CourseQueryDslRepo;
import com.example.university.repo.CourseRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class DynamicQueryService {

    private CourseRepo courseRepo;

    private CourseQueryDslRepo courseQueryDslRepo;

    public DynamicQueryService(CourseRepo courseRepo, CourseQueryDslRepo courseQueryDslRepo) {
        this.courseRepo = courseRepo;
        this.courseQueryDslRepo = courseQueryDslRepo;
    }


    public List<Course> filterBySpecification(CourseFilter filter){
        return courseRepo.findAll(filter.getSpecification());
    }

    public List<Course> fiterByQueryDsl(CourseFilter filter){
        List<Course> courses = new ArrayList<>();
        courseQueryDslRepo.findAll(filter.getQueryDslPredicate()).forEach(courses::add);
        return courses;
    }

    public List<Course> findByExample(CourseFilter filter){
        return courseRepo.findAll(filter.getExampleProbe());
    }

}
