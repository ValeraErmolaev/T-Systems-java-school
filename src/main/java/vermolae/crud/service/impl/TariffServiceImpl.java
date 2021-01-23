package vermolae.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vermolae.crud.dao.api.TariffDAO;
import vermolae.crud.service.api.PictureService;
import vermolae.crud.service.api.TariffService;
import vermolae.exeptions.CustomDAOException;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Picture;
import vermolae.model.entity.Tariff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("tariffService")
public class TariffServiceImpl implements TariffService {

    @Autowired
    private TariffDAO tariffDAO;

    @Autowired
    private PictureService pictureService;

    @Override
    public void createEntity(Tariff entity) throws CustomDAOException {

    }

    @Override
    public Tariff getEntityById(Integer id) throws CustomDAOException {
        return tariffDAO.read(id);
    }

    @Override
    public void updateEntity(Tariff entity) throws CustomDAOException {

    }

    @Override
    public void deleteEntity(Tariff entity) throws CustomDAOException {

    }

    @Override
    @Transactional
    public List<Tariff> getAll() throws CustomDAOException {
        return tariffDAO.getAll();
    }

    @Override
    @Transactional
    public List<TariffViewForm> getTariffViewList(List<Tariff> tariffs) {
        List<TariffViewForm> tariffViewFormList = new ArrayList<TariffViewForm>();
        for (Tariff tariff : tariffs) {
            tariffViewFormList.add(new TariffViewForm(tariff));
        }
        return tariffViewFormList;
    }

    @Override
    @Transactional
    public void updateTariff(Tariff tariff) {
        tariffDAO.update(tariff);
    }

    @Override
    @Transactional
    public Tariff updateTariffImage(int TariffId, MultipartFile file) throws Exception {
        Tariff tariff = getEntityById(TariffId);


        String filename = file.getOriginalFilename();
        pictureService.saveNewPicture(filename,file);
        Picture pictureNew = pictureService.getPictureByName(filename);
        tariff.setPicture(pictureNew);
        updateTariff(tariff);
        //        Picture pictureOld = tariff.getPicture();
//        try{
//            pictureService.deleteEntity(pictureOld);
//        } catch (Exception e){
//            //todo logger
//        }
       return tariff;
    }
}
