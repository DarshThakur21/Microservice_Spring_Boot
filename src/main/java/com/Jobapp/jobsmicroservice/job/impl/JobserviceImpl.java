package com.Jobapp.jobsmicroservice.job.impl;


 import com.Jobapp.jobsmicroservice.job.Job;
 import com.Jobapp.jobsmicroservice.job.JobRepository;
 import com.Jobapp.jobsmicroservice.job.JobService;
 import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobserviceImpl  implements JobService {
//    private List<Job> jobs=new ArrayList<>();


    JobRepository jobRepository;

    public JobserviceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {

        jobRepository.save(job);
    }

    @Override
    public Job findBYid(Long id) {

        return jobRepository. findById(id).orElse(null);

    }

    @Override
    public boolean deleteByid(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while(iterator.hasNext()){
//            Job job=iterator.next();
//            if(job.getId().equals(id)){
//                return true;
//            }
//
//        }
//        return false;
        try {
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updatejob(Long id, Job updatedjob) {
//        for(Job job: jobs){
//            if(job.getId().equals(id)){
//                job.setTitle(updatedjob.getTitle());
//                job.setDescription(updatedjob.getDescription());
//                job.setMinSalary(updatedjob.getMinSalary());
//                job.setMaxSalary(updatedjob.getMaxSalary());
//                job.setLocation(updatedjob.getLocation());
//                return true;
//            }
//        }
//
//        return false;

        Optional<Job> joboptional=jobRepository.findById(id);
        if(joboptional.isPresent()){
            Job job=joboptional.get();
                job.setTitle(updatedjob.getTitle());
                job.setDescription(updatedjob.getDescription());
                job.setMinSalary(updatedjob.getMinSalary());
                job.setMaxSalary(updatedjob.getMaxSalary());
                job.setLocation(updatedjob.getLocation());
                jobRepository.save(job);
                return true;
        }
        return false;
    }

//    @Override
//    public void deleteByid(Long id) {
//        jobs.removeIf(job -> job.getId().equals(id));
//
//    }


}
