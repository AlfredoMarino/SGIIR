SELECT
     tarea.`CodigoTarea` AS tarea_CodigoTarea,
     tarea.`DescripcionTarea` AS tarea_DescripcionTarea,
     tarea.`FechaRecepcionTarea` AS tarea_FechaRecepcionTarea,
     tarea.`FechaEstimadaTarea` AS tarea_FechaEstimadaTarea,
     tarea.`FechaFinalizacionTarea` AS tarea_FechaFinalizacionTarea,
     naturaleza.`TipoNaturaleza` AS naturaleza_TipoNaturaleza,
     naturaleza.`PrioridadNaturaleza` AS naturaleza_PrioridadNaturaleza,
     naturaleza.`CodigoNaturaleza` AS naturaleza_CodigoNaturaleza,
     institucion.`NombreInstitucion` AS institucion_NombreInstitucion
FROM
     `naturaleza` naturaleza INNER JOIN `tarea` tarea ON naturaleza.`CodigoNaturaleza` = tarea.`CodigoNaturaleza`
     INNER JOIN `institucion` institucion ON naturaleza.`CodigoInstitucion` = institucion.`CodigoInstitucion`
WHERE
    tarea.FechaFinalizacionTarea is not null