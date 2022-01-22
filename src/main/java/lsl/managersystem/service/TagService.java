package lsl.managersystem.service;

import lsl.managersystem.domain.Tag;

import java.util.List;

public interface TagService {
    List<Tag> query();
    Tag queryid(String id);
    int insertTag(String name);
    int deleteTag(Integer id);
}