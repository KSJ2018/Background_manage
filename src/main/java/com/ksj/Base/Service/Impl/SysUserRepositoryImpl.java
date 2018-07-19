package com.ksj.Base.Service.Impl;

import com.ksj.Base.Entity.SysResource;
import com.ksj.Base.Entity.SysRole;
import com.ksj.Base.Entity.SysUser;
import com.ksj.Base.Mapper.SysUserMapper;
import com.ksj.Base.Service.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Primary
@Service
public class SysUserRepositoryImpl implements SysUserRepository {
    @Autowired
    SysUserMapper mapper;

    @Override
    public SysUser findByUsername(String username) {
        SysUser user = mapper.findByUsername(username);
        return user;
    }

    @Override
    public List<SysRole> findRolesByUserId(String id) {
        return mapper.findRolesByUserId(id);
    }

    @Override
    public List<SysResource> findResourcesByRoleId(String id) {
        return mapper.findResourcesByRoleId(id);
    }

    @Override
    public List<SysUser> findAll() {
        return null;
    }

    @Override
    public List<SysUser> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SysUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SysUser> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(SysUser sysUser) {

    }

    @Override
    public void deleteAll(Iterable<? extends SysUser> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends SysUser> S save(S s) {
        return null;
    }

    @Override
    public <S extends SysUser> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<SysUser> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends SysUser> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<SysUser> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SysUser getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends SysUser> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SysUser> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SysUser> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SysUser> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SysUser> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SysUser> boolean exists(Example<S> example) {
        return false;
    }
}
