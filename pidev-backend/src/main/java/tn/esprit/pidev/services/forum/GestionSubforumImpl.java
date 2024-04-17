package tn.esprit.pidev.services.forum;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.dto.SubforumDto;
import tn.esprit.pidev.entities.forum.Subforum;
import tn.esprit.pidev.entities.user.User;
import tn.esprit.pidev.repository.user.IUserRepository;
import tn.esprit.pidev.services.forum.exceptions.SpringSubforumException;
import tn.esprit.pidev.services.forum.exceptions.UserNotFoundException;
import tn.esprit.pidev.services.forum.mapper.PostMapper;
import tn.esprit.pidev.services.forum.mapper.SubforumMapper;
import tn.esprit.pidev.repository.forum.IPostRepository;
import tn.esprit.pidev.repository.forum.ISubforumRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class GestionSubforumImpl implements IGestionSubforum {

    @Autowired
    IPostRepository postRepository;
    ISubforumRepository subforumRepository;
    PostMapper postMapper;
    SubforumMapper subforumMapper;
    IUserRepository userRepository;


    @Override
    public SubforumDto save(SubforumDto subforumDto) {
        User user = userRepository.findByEmail(subforumDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + subforumDto.getEmail()));
        Subforum save = subforumRepository.save(subforumMapper.mapDtoToSubforum(subforumDto,user));
        subforumDto.setId(save.getId());
        return subforumDto;
    }

    @Override
    public List<SubforumDto> getAll() {
        return subforumRepository.findAll()
                .stream()
                .map(subforumMapper::mapSubforumToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubforumDto getSubforum(Long id) {
        Subforum subforum = subforumRepository.findById(id)
                .orElseThrow(() -> new SpringSubforumException("No subforum found with ID - " + id));
        return subforumMapper.mapSubforumToDto(subforum);
    }
}
