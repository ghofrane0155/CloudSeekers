package tn.esprit.pidev.services.forum;

import tn.esprit.pidev.dto.SubforumDto;

import java.util.List;

public interface IGestionSubforum {
    SubforumDto save(SubforumDto subforumDto);

    List<SubforumDto> getAll();

    SubforumDto getSubforum(Long id);
}
