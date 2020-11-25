using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using Frankenstein.AspNet.Models;

using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;

namespace Frankenstein.AspNet.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class ViewController : ControllerBase
    {
        private readonly ILogger<ViewController> _logger;
        private readonly FurnitureContext _context;

        public ViewController(ILogger<ViewController> logger, FurnitureContext context)
        {
            _logger = logger;
            _context = context;
        }

        [HttpGet("/:id")]
        public async Task<Furniture> GetById(int id)
        {
            return await _context.Furnitures.FirstAsync(f => f.Id == id);
        }

        [HttpGet]
        public async Task<IEnumerable<Furniture>> GetAll()
        {
            return await _context.Furnitures.ToListAsync();
        }
    }
}
