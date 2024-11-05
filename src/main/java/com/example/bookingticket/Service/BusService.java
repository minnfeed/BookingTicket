//package com.example.bookingticket.Service;
//
//
//import com.example.bookingticket.Repository.BusRepository;
//import com.example.bookingticket.Service.Interfaces.IBusService;
//
//import com.example.bookingticket.Util.ObjectsValidator;
//import com.example.bookingticket.models.dtos.Bus.BusRespondDTO;
//import com.example.bookingticket.models.dtos.Bus.CreateBusDTO;
//import com.example.bookingticket.models.entities.BusEntity;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class BusService implements IBusService {
//
//    BusRepository busRepository;
//    BusMapper busMapper;
//    ObjectsValidator<CreateBusDTO> validator;
//
//    @Override
//    public List<BusRespondDTO> findAll() {
//        List<BusEntity> buses = busRepository.findAll();
//        return buses.stream()
//                .map(busMapper::toRespondDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<BusRespondDTO> findById(Integer id) {
//        Optional<BusEntity> entity = busRepository.findById(id);
//        return entity.map(busMapper::toRespondDTO);
//    }
//}
