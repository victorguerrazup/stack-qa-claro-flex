from templateframework.metadata import Metadata
from os import path

def run(metadata: Metadata = None):
  inputs = metadata.all_inputs()
  has_body = inputs['has_body']

  if has_body:
    computed_inputs = metadata.computed_inputs
    target_path = metadata.target_path

    apiFile = path.join(target_path, 'base-module', 'src', 'main', 'kotlin', 'apis', computed_inputs['service_name_pascal'] + '.kt')
    pojoFile = path.join(target_path, 'base-module', 'src', 'main', 'kotlin', 'pojos', computed_inputs['service_name_pascal'] + 'Pojo.kt')

    if not path.exists(pojoFile):
      with open(pojoFile, 'w') as pojo:
        pojo.writelines(['package pojos\n', '\n', '//Defina o POJO\n', 'class ' + computed_inputs['service_name_pascal'] +'Pojo {}'])
    
    api = open(apiFile, 'rt')
    apiData = api.read()
    api.close()

    importPojo = 'import pojos.' + computed_inputs['service_name_pascal'] + 'Pojo'
    importConst = 'import constants.' + computed_inputs['service_name_pascal'] + 'Const'

    if importPojo not in apiData:
      apiData = apiData.replace(importConst, importPojo + '\n' + importConst)
      api = open(apiFile, 'wt')
      api.write(apiData)
      api.close()

  return metadata