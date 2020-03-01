package com.example.project.hrapp.restApi;

import com.example.project.hrapp.applicant.Applicant;
import com.example.project.hrapp.applicant.ApplicantService;
import com.example.project.hrapp.job.Job;
import com.example.project.hrapp.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private JobService jobService;
    @Autowired
    private ApplicantService applicantService;
    public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Job> listJobs = jobService.listAll();
        int length = listJobs.size();//listenin uzunluğunu alıyorum. Eğer 'length=0' ise home sayfasında mesaj gösterilecek.
        model.addAttribute("listJobs",listJobs);
        model.addAttribute("length",length);
        return "home";

    }
    @RequestMapping("/hello")
    public String managerHomePage(Model model){
        List<Job> listJobs = jobService.listAll();
        int length = listJobs.size();
        model.addAttribute("listJobs",listJobs);
        model.addAttribute("length",length);
        return "manager_home";

    }
    @RequestMapping("/manager-job-list")
    public String managerJobList(Model model){
        List<Job> listJobs = jobService.listAll();
        int length = listJobs.size();
        model.addAttribute("listJobs",listJobs);
        model.addAttribute("length",length);

        return "manager_job_list";

    }

    @RequestMapping("/new")
    public String newJobForm(Model model){
        Job job =new Job();
        model.addAttribute("job",job);
        return "new_job";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveJob(@ModelAttribute("job") Job job){

        jobService.save(job);

        return "redirect:/manager-job-list";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editJobForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_job");

        Job job = jobService.getById(id);
        mav.addObject("job",job);

        return mav;

    }
    @RequestMapping("/apply/{id}")
    public String applyJobForm(Model model, @PathVariable(name = "id") Long id){
        Applicant applicant =new Applicant();
        Job job = jobService.getById(id);
        applicant.setJobName(job.getJobTitle().toString());
        model.addAttribute("applicant",applicant);
        model.addAttribute("job",job);

        return "apply_job";

    }
    @RequestMapping("/applicants")
    public String viewApplicantsPage(Model model){
        List<Applicant> listApplicants = applicantService.listAll();
        int length = listApplicants.size();
        model.addAttribute("listApplicants",listApplicants);
        model.addAttribute("length",length);
        return "list_applicants";

    }



    @RequestMapping("/applicant/{id}")
    public String applicantDetail(Model model, @PathVariable(name = "id") Long id){

        Applicant applicant = applicantService.getById(id);
        model.addAttribute("applicant",applicant);

        return "applicant_detail";

    }

    @RequestMapping("/delete/{id}")
    public String deleteJob(@PathVariable(name= "id") Long id){
        jobService.delete(id);

        return "redirect:/manager-job-list";

    }
    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String upload(Model model, @RequestParam("files") MultipartFile[] files, @ModelAttribute("applicant") Applicant applicant ) throws IOException {

        StringBuilder fileNames = new StringBuilder();
        for(MultipartFile file : files){
            Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename());
            try{
                Files.write(fileNameAndPath, file.getBytes());
            }catch (IOException e){
                e.printStackTrace();

            }
        }


        applicantService.save(applicant);

        model.addAttribute("msg","Başvurunuz başarıyla tamamlandı. Dosya(lar) yüklendi. "+fileNames.toString());
        return "uploadstatusview";

    }

}
