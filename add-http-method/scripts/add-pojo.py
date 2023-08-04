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
    factoryFile = path.join(target_path, 'base-module', 'src', 'main', 'kotlin', 'factories', computed_inputs['service_name_pascal'] + 'Factory.kt')

    if not path.exists(pojoFile):
      with open(pojoFile, 'w') as pojo:
        pojo.writelines([
          'package pojos\n', 
          '\n\n', 
          '//Defina o POJO\n', 
          f'class {computed_inputs["service_name_pascal"]}Pojo {{}}'
        ])

    if not path.exists(factoryFile):
      with open(factoryFile, 'w') as pojo:
        pojo.writelines([
          'package factories\n',
          f'import pojos.{computed_inputs["service_name_pascal"]}Pojo\n',
          'import utils.Mass\n',
          '\n',
          f'class {computed_inputs["service_name_pascal"]}Factory {{\n',
          '\n',
          '    private val mass = Mass()\n',
          '\n',
          f'    fun myFactory(): {computed_inputs["service_name_pascal"]}Pojo {{\n',
          f'        val {computed_inputs["service_name_camelcase"]}Pojo = {computed_inputs["service_name_pascal"]}Pojo()\n',
          f'        return {computed_inputs["service_name_camelcase"]}Pojo\n',
          '    }\n',
          '}'
        ])
    
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