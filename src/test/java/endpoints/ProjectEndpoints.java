package endpoints;

public interface ProjectEndpoints {

    String GET_ALL_PROJECTS = "https://api.qase.io/v1/project";
    String GET_ALL_PROJECTSWrong = "https://api.qase.io/v1/project2";
    String GET_PROJECT = "https://api.qase.io/v1/project/%s"; //%s - projectCode
    String POST_ADD_PROJECT = "https://api.qase.io/v1/project";
    String DELETE_PROJECT = "https://api.qase.io/v1/project/%s"; //%s - projectCode


}
