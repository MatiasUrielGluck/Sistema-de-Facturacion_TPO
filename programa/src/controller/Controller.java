package controller;

import dao.ModelDao;
import dto.ModelDto;
import model.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Controller INSTANCE = null;

    private static ModelDao modelDao;

    private static List<Model> modelList;


    private Controller(List<Model> modelList){this.modelList = modelList;}

    public static synchronized Controller getInstances() throws Exception {
        if(INSTANCE == null) {
            INSTANCE = new Controller(initModel());
            modelDao = new ModelDao(Model.class,getPathOutModel(Model.class.getSimpleName()));
        }
        return INSTANCE;
    }


    public void addModel(ModelDto dto) throws Exception {
        if(getByIdModel(dto.getIdModel()) == null){
           modelDao.save(toModel(dto));
        }
    }

    public ModelDto getByIdModel(String id) throws Exception {
        for (Model model: modelList) {
            if (model.getId().equals(id)){
                return toDto(model);
            }
        }
        return  null;
    }

    public void deleteByIdModel(String id){
        int index = getIndex(id);
        if(index != -1){
             modelList.remove(index);
        }
    }

    private int getIndex(String id){
        for (int i=0;i<modelList.size();i++){
            if(modelList.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public List<ModelDto> getAll() throws Exception {
        List<ModelDto> dtoList = new ArrayList<>();
        /*
        for (Model model : modelDao.getAll(Model.class)) {
            dtoList.add(toDto(model));
        }*/
        for (Model model : modelList) {
            dtoList.add(toDto(model));
        }
        return dtoList;
    }

    private static String getPathOutModel(String name){
        String dir = "C:/IOO/";
        return  new File(dir+name+".json").getPath();
    }

    public static Model toModel(ModelDto dto){
        return new Model(dto.getIdModel(),dto.getNameModel());
    }

    public static ModelDto toDto(Model model){
        return new ModelDto(model.getId(),model.getName());
    }

    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(ArrayList<Model> modelList){
        this.modelList = modelList;
    }

    private static List<Model> initModel(){
        modelList = new ArrayList<>();
        modelList.add(new Model("12321","name1"));
        modelList.add(new Model("12321","name2"));
        modelList.add(new Model("12321","name3"));
        modelList.add(new Model("12321","name3"));
        return  modelList;

    }
}
