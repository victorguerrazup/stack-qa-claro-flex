from templateframework.metadata import Metadata
from os import path

def run(metadata: Metadata = None):
  inputs = metadata.all_inputs()
  has_body = inputs['has_body']

  inputs_computed_global = metadata.global_computed_inputs
  target_path = metadata.target_path

  apiFile = path.join(target_path, 'base-module', 'src', 'main', 'kotlin', 'apis', inputs_computed_global['service_name_pascal'] + '.kt')
  pojoFile = path.join(target_path, 'base-module', 'src', 'main', 'kotlin', 'pojos', inputs_computed_global['service_name_pascal'] + 'Pojo.kt')
  
  if has_body:
    if not path.exists(pojoFile):
      with open(pojoFile, 'w') as pojo:
        pojo.writelines(['package pojos\n', '\n', '//Defina o POJO\n', 'class ' + inputs_computed_global['service_name_pascal'] +'Pojo {}'])
    
    api = open(apiFile, 'rt')
    apiData = api.read()
    api.close()

    importPojo = 'import pojos.' + inputs_computed_global['service_name_pascal'] + 'Pojo'
    importConst = 'import constants.' + inputs_computed_global['service_name_pascal'] + 'Const'

    if importPojo not in apiData:
      apiData = apiData.replace(importConst, importPojo + '\n' + importConst)
      api = open(apiFile, 'wt')
      api.write(apiData)
      api.close()
  return metadata