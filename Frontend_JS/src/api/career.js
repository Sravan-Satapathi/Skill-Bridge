import { api } from './client'

export const careerApi = {
  getProfile: () => api.get('/career-profile'),
  updateProfile: (data) => api.put('/career-profile', data),
  addSkill: (data) => api.post('/career-profile/skills', data),
  addSkillsBulk: (skills, source) => api.post('/career-profile/skills/bulk', { skills, source }),
  removeSkill: (skillId) => api.delete(`/career-profile/skills/${skillId}`),
  extractSkills: (text, mergeStrategy) =>
    api.post('/career-profile/skills/extract', { text, mergeStrategy }),
  extractSkillsFromFile: (file, mergeStrategy) =>
    api.postForm('/career-profile/skills/extract', file, mergeStrategy),
  getGaps: (roleId) => api.get(`/career-profile/gaps?roleId=${roleId}`),
  getRoadmap: (roleId) => api.get(`/career-profile/roadmap?roleId=${roleId}`),
}

export const rolesApi = {
  getAll: () => api.get('/roles').then((r) => r.roles),
  getById: (id) => api.get(`/roles/${id}`),
}
