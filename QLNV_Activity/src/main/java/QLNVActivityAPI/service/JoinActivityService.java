package QLNVActivityAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QLNVActivityAPI.model.Activity;
import QLNVActivityAPI.model.JoinActivity;
import QLNVActivityAPI.repository.ActivityRepository;
import QLNVActivityAPI.repository.JoinActivityRepository;

@Service
public class JoinActivityService {

    @Autowired
    private JoinActivityRepository joinActivityRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getActivitiesByEmployeeID(int empid) {
        List<JoinActivity> joinActivities = joinActivityRepository.findByEmployeeID(empid);

        List<Integer> activityIDs = joinActivities.stream()
            .map(JoinActivity::getActivityID)
            .distinct()
            .collect(Collectors.toList());

        return activityRepository.findAllByActivityIDIn(activityIDs);
    }
    
    public long countJoinActivityByActivityIDAndEmployeeID(int activityID, int employeeID) {
        return joinActivityRepository.countByActivityIDAndEmployeeID(activityID, employeeID);
    }
}
